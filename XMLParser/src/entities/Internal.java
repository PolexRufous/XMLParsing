//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.20 at 10:32:30 PM EEST 
//


package entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Internal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Internal">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/simpleXMLSchema}AbstractType">
 *       &lt;sequence>
 *         &lt;element name="port" type="{http://www.example.org/simpleXMLSchema}intPort"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Internal", propOrder = {
    "port"
})
public class Internal
    extends AbstractType
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected IntPort port;

    /**
     * Gets the value of the port property.
     * 
     * @return
     *     possible object is
     *     {@link IntPort }
     *     
     */
    public IntPort getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntPort }
     *     
     */
    public void setPort(IntPort value) {
        this.port = value;
    }

}