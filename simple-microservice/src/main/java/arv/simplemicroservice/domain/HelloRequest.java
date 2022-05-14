package arv.simplemicroservice.domain;

import lombok.Data;

/**
 * @author ArvikV
 * @version 1.0
 * @since 15.05.2022
 */
@Data
public class HelloRequest {
    private String firstName;
    private String lastName;
}
