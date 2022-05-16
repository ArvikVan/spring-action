package arv.licensingservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

/**
 * @author ArvikV
 * @version 1.0
 * @since 16.05.2022
 */
@Getter
@Setter
@ToString
public class License extends RepresentationModel<License> {
    private int id;
    private String licenseId;
    private String description;
    private String organizationId;
    private String productName;
    private String LicenseType;
}
