package arv.licensingservice.controller;

import arv.licensingservice.model.License;
import arv.licensingservice.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * @author ArvikV
 * @version 1.0
 * @since 16.05.2022
 */
@RestController
@RequestMapping("v1/organization/{organizationId}/license")
public class LicenseController {
    @Autowired
    private LicenseService licenseService;

    @GetMapping("/{licenseId}")
    public ResponseEntity<License> getLicense(@PathVariable ("organizationId") String organizationId,
                                              @PathVariable ("licenseId") String licenseId) {
        License license = licenseService.getLicense(licenseId, organizationId);
        return ResponseEntity.ok(license);
    }
    @PutMapping
    public ResponseEntity<String> updateLicense(@PathVariable ("organizationId") String organizationId,
                                                @RequestBody License license,
                                                @RequestHeader (value = "Accept-Language",required = false)
                                                    Locale locale) {
        return ResponseEntity.ok(licenseService.updateLicense(license, organizationId, locale));
    }
    @PostMapping
    public ResponseEntity<String> createLicense(@PathVariable ("organizationId") String organizationId,
                                                @RequestBody License request,
                                                @RequestHeader (value = "Accept-Language",required = false)
                                                Locale locale) {
        return ResponseEntity.ok(licenseService.createLicense(request, organizationId, locale));
    }
    @DeleteMapping("/{licenseId}")
    public ResponseEntity<String> deletLicense(@PathVariable ("organizationId") String organizationId,
                                               @PathVariable ("licenseId") String licenseId) {
        return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organizationId));

    }

}
