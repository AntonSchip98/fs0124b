package it.schipani.services.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class PostDto {
    private String category;
    private String title;
    private String cover;
    private String content;
    private Double lectureTime;

}
