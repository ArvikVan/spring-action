package arv.licensingservice.controller;

import arv.licensingservice.model.License;
import arv.licensingservice.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author ArvikV
 * @version 1.0
 * @since 16.05.2022
 * добавлены hateos
 */
@RestController
@RequestMapping("v1/organization/{organizationId}/license")
public class LicenseController {
    @Autowired
    private LicenseService licenseService;

    /**
     * получаем лизензию
     * @param organizationId ид организации
     * @param licenseId ид лицензии
     * @return на выходе лицензия с полным набором данных, включая связанные апи
     */
    @GetMapping("/{licenseId}")
    public ResponseEntity<License> getLicense(@PathVariable ("organizationId") String organizationId,
                                              @PathVariable ("licenseId") String licenseId) {
        License license = licenseService.getLicense(licenseId, organizationId);
        license.add(linkTo(methodOn(LicenseController.class)
                        .getLicense(organizationId, license.getLicenseId()))
                        .withSelfRel(),
                linkTo(methodOn(LicenseController.class)
                        .createLicense(organizationId, license, null))
                        .withRel("createLicense"),
                linkTo(methodOn(LicenseController.class)
                        .updateLicense(organizationId, license))
                        .withRel("updateLicense"),
                linkTo(methodOn(LicenseController.class)
                        .deleteLicense(organizationId, license.getLicenseId()))
                        .withRel("deleteLicense"));
        return ResponseEntity.ok(license);
    }
    @PutMapping
    public ResponseEntity<String> updateLicense(@PathVariable ("organizationId") String organizationId,
                                                @RequestBody License license) {
        return ResponseEntity.ok(licenseService.updateLicense(license, organizationId));
    }
    @PostMapping
    public ResponseEntity<String> createLicense(@PathVariable ("organizationId") String organizationId,
                                                @RequestBody License request,
                                                @RequestHeader (value = "Accept-Language",required = false)
                                                Locale locale) {
        return ResponseEntity.ok(licenseService.createLicense(request, organizationId, locale));
    }
    @DeleteMapping("/{licenseId}")
    public ResponseEntity<String> deleteLicense(@PathVariable ("organizationId") String organizationId,
                                               @PathVariable ("licenseId") String licenseId) {
        return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organizationId));

    }

}
