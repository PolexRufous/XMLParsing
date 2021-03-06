//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.20 at 10:32:30 PM EEST 
//


package entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for intPort.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="intPort">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PCI"/>
 *     &lt;enumeration value="IDE"/>
 *     &lt;enumeration value="SATA"/>
 *     &lt;enumeration value="DIMM"/>
 *     &lt;enumeration value="SIMM"/>
 *     &lt;enumeration value="PCIE"/>
 *     &lt;enumeration value="Socket"/>
 *     &lt;enumeration value="Base"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "intPort")
@XmlEnum
public enum IntPort {

    PCI("PCI"),
    IDE("IDE"),
    SATA("SATA"),
    DIMM("DIMM"),
    SIMM("SIMM"),
    PCIE("PCIE"),
    @XmlEnumValue("Socket")
    SOCKET("Socket"),
    @XmlEnumValue("Base")
    BASE("Base");
    private final String value;

    IntPort(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IntPort fromValue(String v) {
        for (IntPort c: IntPort.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
