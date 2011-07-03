//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.03 at 04:01:48 PM NZST 
//


package rabbit.data.internal.xml.schema.events;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rabbit.data.internal.xml.schema.events package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Events_QNAME = new QName("", "events");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rabbit.data.internal.xml.schema.events
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JavaEventType }
     * 
     */
    public JavaEventType createJavaEventType() {
        return new JavaEventType();
    }

    /**
     * Create an instance of {@link TaskIdType }
     * 
     */
    public TaskIdType createTaskIdType() {
        return new TaskIdType();
    }

    /**
     * Create an instance of {@link PartEventType }
     * 
     */
    public PartEventType createPartEventType() {
        return new PartEventType();
    }

    /**
     * Create an instance of {@link SessionEventType }
     * 
     */
    public SessionEventType createSessionEventType() {
        return new SessionEventType();
    }

    /**
     * Create an instance of {@link PerspectiveEventListType }
     * 
     */
    public PerspectiveEventListType createPerspectiveEventListType() {
        return new PerspectiveEventListType();
    }

    /**
     * Create an instance of {@link FileEventType }
     * 
     */
    public FileEventType createFileEventType() {
        return new FileEventType();
    }

    /**
     * Create an instance of {@link EventListType }
     * 
     */
    public EventListType createEventListType() {
        return new EventListType();
    }

    /**
     * Create an instance of {@link LaunchEventListType }
     * 
     */
    public LaunchEventListType createLaunchEventListType() {
        return new LaunchEventListType();
    }

    /**
     * Create an instance of {@link CommandEventListType }
     * 
     */
    public CommandEventListType createCommandEventListType() {
        return new CommandEventListType();
    }

    /**
     * Create an instance of {@link CommandEventType }
     * 
     */
    public CommandEventType createCommandEventType() {
        return new CommandEventType();
    }

    /**
     * Create an instance of {@link JavaEventListType }
     * 
     */
    public JavaEventListType createJavaEventListType() {
        return new JavaEventListType();
    }

    /**
     * Create an instance of {@link IntervalEventType }
     * 
     */
    public IntervalEventType createIntervalEventType() {
        return new IntervalEventType();
    }

    /**
     * Create an instance of {@link SessionEventListType }
     * 
     */
    public SessionEventListType createSessionEventListType() {
        return new SessionEventListType();
    }

    /**
     * Create an instance of {@link EventGroupType }
     * 
     */
    public EventGroupType createEventGroupType() {
        return new EventGroupType();
    }

    /**
     * Create an instance of {@link PartEventListType }
     * 
     */
    public PartEventListType createPartEventListType() {
        return new PartEventListType();
    }

    /**
     * Create an instance of {@link TaskFileEventListType }
     * 
     */
    public TaskFileEventListType createTaskFileEventListType() {
        return new TaskFileEventListType();
    }

    /**
     * Create an instance of {@link DurationEventType }
     * 
     */
    public DurationEventType createDurationEventType() {
        return new DurationEventType();
    }

    /**
     * Create an instance of {@link FileEventListType }
     * 
     */
    public FileEventListType createFileEventListType() {
        return new FileEventListType();
    }

    /**
     * Create an instance of {@link PerspectiveEventType }
     * 
     */
    public PerspectiveEventType createPerspectiveEventType() {
        return new PerspectiveEventType();
    }

    /**
     * Create an instance of {@link CountEventType }
     * 
     */
    public CountEventType createCountEventType() {
        return new CountEventType();
    }

    /**
     * Create an instance of {@link TaskFileEventType }
     * 
     */
    public TaskFileEventType createTaskFileEventType() {
        return new TaskFileEventType();
    }

    /**
     * Create an instance of {@link LaunchEventType }
     * 
     */
    public LaunchEventType createLaunchEventType() {
        return new LaunchEventType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "events")
    public JAXBElement<EventListType> createEvents(EventListType value) {
        return new JAXBElement<EventListType>(_Events_QNAME, EventListType.class, null, value);
    }

}
