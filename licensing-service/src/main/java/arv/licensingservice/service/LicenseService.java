package arv.licensingservice.service;

import arv.licensingservice.model.License;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author ArvikV
 * @version 1.0
 * @since 16.05.2022
 */
@Service
public class LicenseService {
    public License getLicense(String licenseId, String organizationId) {
        License license = new License();
        license.setId(new Random().nextInt(1000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("Ostock");
        license.setLicenseType("full");
        return license;
    }

    public String createLicense(License license, String organizationId) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format("This is the post and thr object is: %s", license.toString());
        }
        return responseMessage;
    }

    public String updateLicense(License license, String organizationId) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format("This is the put (update) and thr object is: %s", license.toString());
        }
        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId) {
        String responseMessage = null;
        responseMessage = String.format("Deleting license with id %s for the organization %s", licenseId, organizationId);
        return responseMessage;
    }
}