/*
 * Copyright 2010 The Rabbit Eclipse Plug-in Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package rabbit.ui.internal.pages;

import rabbit.data.access.model.PartDataDescriptor;
import rabbit.ui.internal.util.ICategory;
import rabbit.ui.internal.util.UndefinedWorkbenchPartDescriptor;
import rabbit.ui.internal.viewers.TreeNodes;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;

import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IWorkbenchPartDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.IViewDescriptor;
import org.eclipse.ui.views.IViewRegistry;
import org.joda.time.LocalDate;

import java.util.Collection;

/**
 * Content provider for a {@code TreeViewer}. Acceptable input is {@code
 * Collection<PartDataDescriptor>}. *
 * <p>
 * The following {@link ICategory}s are supported:
 * <ul>
 * <li>{@link Category#DATE}</li>
 * <li>{@link Category#WORKBENCH_TOOL}</li>
 * </ul>
 * </p>
 */
public class PartPageContentProvider extends AbstractValueContentProvider {
  
  private boolean hideEditors = false;
  private boolean hideViews = false;
  
  /**
   * Predicate used to filter out editors if {@link #isHidingEditors()} returns 
   * true.
   */
  private final Predicate<Object> filterEditors = new Predicate<Object>() {
    @Override public boolean apply(Object input) {
      return isHidingEditors() ? !(input instanceof IEditorDescriptor) : true;
    }
  };
  
  /**
   * Predicate used to filter out editors if {@link #isHidingViews()} returns 
   * true.
   */
  private final Predicate<Object> filterViews = new Predicate<Object>() {
    @Override public boolean apply(Object input) {
      return isHidingViews() ? !(input instanceof IViewDescriptor) : true;
    }
  };
  
  /**
   * Constructs a new content provider for the given viewer.
   * @param treeViewer The viewer.
   * @throws NullPointerException If argument is null.
   */
  public PartPageContentProvider(TreeViewer treeViewer) {
    super(treeViewer);

    treeViewer.addFilter(new ViewerFilter() {
      @Override
      public boolean select(Viewer viewer, Object parentElement, Object element) {
        if (element instanceof TreeNode) {
          element = ((TreeNode) element).getValue();
        }
        if (element instanceof IEditorDescriptor) {
          return !isHidingEditors();
        } else if (element instanceof IViewDescriptor) {
          return !isHidingViews();
        } else {
          return true;
        }
      }
    });
  }
  
  /**
   * Checks whether editors are currently hidden.
   * @return True if editors are hidden, false if they are showing.
   */
  public boolean isHidingEditors() {
    return hideEditors;
  }
  
  /**
   * Checks whether views are currently hidden.
   * @return True if views are hidden, false if they are showing.
   */
  public boolean isHidingViews() {
    return hideViews;
  }
  
  /**
   * TODO test
   * Sets whether editors should be hidden.
   * @param hide True to hide editors, false to show editors.
   */
  public void setHideEditors(boolean hide) {
    if (hideEditors != hide) {
      hideEditors = hide;
      updateMaxValue();
      getViewer().refresh(false);
    }
  }
  
  /**
   * Sets whether views should be hiden.
   * @param hide True to hide views, false to show views.
   */
  public void setHideViews(boolean hide) {
    if (hideViews != hide) {
      hideViews = hide;
      updateMaxValue();
      getViewer().refresh(false);
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  protected void doInputChanged(Viewer viewer, Object oldInput, Object newInput) {
    super.doInputChanged(viewer, oldInput, newInput);
    getRoot().setChildren(null);
    
    Collection<PartDataDescriptor> data = (Collection<PartDataDescriptor>) newInput;
    IEditorRegistry editors = PlatformUI.getWorkbench().getEditorRegistry();
    IViewRegistry views = PlatformUI.getWorkbench().getViewRegistry();
    for (PartDataDescriptor des : data) {
      
      TreeNode node = getRoot();
      for (ICategory cat : selectedCategories) {
        if (Category.DATE == cat) {
          node = TreeNodes.findOrAppend(node, des.getDate());
          
        } else if (Category.WORKBENCH_TOOL == cat) {
          IWorkbenchPartDescriptor part = editors.findEditor(des.getPartId());
          if (part == null) 
            part = views.find(des.getPartId());
          if (part == null)
            part = new UndefinedWorkbenchPartDescriptor(des.getPartId());
          
          node = TreeNodes.findOrAppend(node, part);
        }
      }
      TreeNodes.appendToParent(node, des.getValue());
    }
  }

  @Override
  protected ICategory[] getAllSupportedCategories() {
    return new ICategory[] { Category.DATE, Category.WORKBENCH_TOOL };
  }

  @Override
  protected ICategory getDefaultPaintCategory() {
    return Category.WORKBENCH_TOOL;
  }

  @Override
  protected ICategory[] getDefaultSelectedCategories() {
    return new ICategory[] { Category.WORKBENCH_TOOL };
  }

  @Override
  protected ImmutableMap<ICategory, Predicate<Object>> initializeCategorizers() {
    return ImmutableMap.<ICategory, Predicate<Object>> builder()
        .put(Category.DATE, Predicates.instanceOf(LocalDate.class))
        .put(Category.WORKBENCH_TOOL, Predicates.instanceOf(IWorkbenchPartDescriptor.class))
        .build();
  }
  
  @Override
  protected void updateMaxValue() {
    Predicate<Object> filters = Predicates.and(filterEditors, filterViews);
    maxValue = TreeNodes.findMaxLong(getRoot(), 
        Predicates.and(filters, getCategorizers().get(getPaintCategory())));
  }
}
