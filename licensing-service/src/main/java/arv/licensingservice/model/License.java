package arv.licensingservice.model;

import lombok.Data;

/**
 * @author ArvikV
 * @version 1.0
 * @since 16.05.2022
 */
@Data
public class License {
    private int id;
    private String licenseId;
    private String description;
    private String organizationId;
    private String productName;
    private String LicenseType;
}
