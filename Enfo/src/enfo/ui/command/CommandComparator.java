package enfo.ui.command;

import org.eclipse.core.commands.Category;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

public class CommandComparator extends ViewerComparator {
	
	private static final String UNCATEGORIZED_ID = "org.eclipse.core.commands.categories.autogenerated"
		;

	public CommandComparator() {
		super();
	}
	
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		if ((e1 instanceof Command) && (e2 instanceof Command)) {
			
			Command cmd1 = (Command) e1;
			Command cmd2 = (Command) e2;
			
			if (!cmd1.isDefined()) {
				return 1;
			}
			
			if (!cmd2.isDefined()) {
				return -1;
			}
			
			try {
				return cmd1.getName().compareTo(cmd2.getName());
			} catch (NotDefinedException e) {
				return cmd1.getId().compareTo(cmd2.getId());
			}
			
		} else if ((e1 instanceof Category) && (e2 instanceof Category)) {
			
			Category cat1 = (Category) e1;
			Category cat2 = (Category) e2;
			
			if (cat1.getId().equals(UNCATEGORIZED_ID)) {
				return 1;
			}
			
			if (cat2.getId().equals(UNCATEGORIZED_ID)) {
				return -1;
			}
			
			try {
				return cat1.getName().compareTo(cat2.getName());
			} catch (NotDefinedException e) {
				return cat1.getId().compareTo(cat2.getId());
			}
		}
		return super.compare(viewer, e1, e2);
	}
}