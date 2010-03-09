package rabbit.core.internal.storage.xml;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import rabbit.core.events.CommandEvent;
import rabbit.core.internal.storage.xml.schema.events.CommandEventListType;
import rabbit.core.internal.storage.xml.schema.events.CommandEventType;
import rabbit.core.internal.storage.xml.schema.events.EventListType;

public class CommandEventStorer
		extends AbstractStorer<CommandEvent, CommandEventType, CommandEventListType> {

	/**
	 * Constructor.
	 */
	public CommandEventStorer() {
		super();
	}

	@Override
	public CommandEventType newXmlType(CommandEvent e) {
		CommandEventType type = OBJECT_FACTORY.createCommandEventType();
		type.setCommandId(e.getExecutionEvent().getCommand().getId());
		type.setCount(1);
		return type;
	}

	@Override
	public boolean hasSameId(CommandEventType x, CommandEvent e) {

		return e.getExecutionEvent().getCommand().getId()
				.equals(x.getCommandId());
	}

	@Override
	public void merge(CommandEventType x, CommandEvent e) {
		x.setCount(x.getCount() + 1);
	}

	@Override
	public boolean hasSameId(CommandEventType x1, CommandEventType x2) {
		return x1.getCommandId().equals(x2.getCommandId());
	}

	@Override
	public void merge(CommandEventType x1, CommandEventType x2) {
		x1.setCount(x1.getCount() + x2.getCount());
	}

	@Override
	public void merge(CommandEventListType t1, CommandEventListType t2) {
		merge(t1.getCommandEvent(), t2.getCommandEvent());
	}

	@Override
	public List<CommandEventListType> getXmlTypeCategories(EventListType events) {
		return events.getCommandEvents();
	}

	@Override
	public void merge(CommandEventListType main, CommandEvent e) {
		merge(main.getCommandEvent(), e);
	}

	@Override
	public CommandEventListType newXmlTypeHolder(XMLGregorianCalendar date) {
		CommandEventListType type = OBJECT_FACTORY.createCommandEventListType();
		type.setDate(date);
		return type;
	}

	@Override
	public IDataStore getDataStore() {
		return DataStore.COMMAND_STORE;
	}
}
