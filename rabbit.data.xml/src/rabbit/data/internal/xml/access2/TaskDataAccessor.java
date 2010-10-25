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
package rabbit.data.internal.xml.access2;

import rabbit.data.access.model.ITaskData;
import rabbit.data.access.model.WorkspaceStorage;
import rabbit.data.common.TaskId;
import rabbit.data.internal.access.model.TaskData;
import rabbit.data.internal.xml.IDataStore;
import rabbit.data.internal.xml.StoreNames;
import rabbit.data.internal.xml.access.AbstractNodeAccessor;
import rabbit.data.internal.xml.merge.IMerger;
import rabbit.data.internal.xml.schema.events.EventListType;
import rabbit.data.internal.xml.schema.events.TaskFileEventListType;
import rabbit.data.internal.xml.schema.events.TaskFileEventType;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.joda.time.Duration;
import org.joda.time.LocalDate;

import java.util.Collection;

/**
 * Gets task data.
 */
public class TaskDataAccessor 
    extends AbstractNodeAccessor<ITaskData, 
                                 TaskFileEventType, 
                                 TaskFileEventListType> {

  /**
   * Constructor.
   * 
   * @param store The data store to get the data from.
   * @param merger The merger for merging XML data nodes.
   * @throws NullPointerException If any arguments are null.
   */
  @Inject
  TaskDataAccessor(
      @Named(StoreNames.TASK_STORE) IDataStore store,
      IMerger<TaskFileEventType> merger) {
    super(store, merger);
  }

  @Override
  protected ITaskData createDataNode(LocalDate date, WorkspaceStorage ws,
      TaskFileEventType t) throws Exception {
    Duration duration = new Duration(t.getDuration());
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    IFile file = root.getFile(new Path(t.getFilePath()));
    TaskId taskId = new TaskId(t.getTaskId().getHandleId(), 
        t.getTaskId().getCreationDate().toGregorianCalendar().getTime());
    return new TaskData(date, ws, duration, file, taskId);
  }
  
  @Override
  protected Collection<TaskFileEventListType> getCategories(EventListType doc) {
    return doc.getTaskFileEvents();
  }

  @Override
  protected Collection<TaskFileEventType> getElements(TaskFileEventListType t) {
    return t.getTaskFileEvent();
  }
}