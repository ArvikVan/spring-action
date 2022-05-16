package arv.licensingservice.service;

import arv.licensingservice.model.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

/**
 * @author ArvikV
 * @version 1.0
 * @since 16.05.2022
 */
@Service
public class LicenseService {
    @Autowired
    MessageSource messages;
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

    /**
     * метод создания лицухи
     * @param license лицензия
     * @param organizationId ид организации
     * @param locale локаль
     * @return на выходе сообщение
     * добавили локаль в вывод
     */
    public String createLicense(License license, String organizationId, Locale locale) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(messages.getMessage(
                    "license.create.message", null, locale), license.toString());
        }
        return responseMessage;
    }

    /**
     * метод обновления
     *
     * @param license        лицензия
     * @param organizationId ид организации
     * @return на выходе обновленная лицензия
     */
    public String updateLicense(License license, String organizationId) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(messages.getMessage(
                    "license.update.message", null, null), license.toString());
        }
        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId) {
        String responseMessage = null;
        responseMessage = String.format("Deleting license with id %s for the organization %s", licenseId, organizationId);
        return responseMessage;
    }
}
