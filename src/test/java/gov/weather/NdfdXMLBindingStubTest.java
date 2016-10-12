package gov.weather;

import gov.weather.NdfdXMLBindingStub;
import gov.weather.NdfdXMLLocator;
import java.io.*;
import javax.xml.bind.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by craigwilson on 10/12/16.
 */
public class NdfdXMLBindingStubTest {
    @Test
    public void latLonListZipCode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub)
                    new NdfdXMLLocator().getndfdXMLPort();

        String result = binding.latLonListZipCode("53711");

        try {
            // create JAXB context and initializing Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Creating Java object from the XML string
            DwmlType dwml = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(result));

            assertEquals("Results did not match expected value.", "43.0798,-89.3875", dwml.getLatLonList());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}