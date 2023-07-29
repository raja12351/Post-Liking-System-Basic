package Dtos.RequestDtos;

import lombok.Data;

import java.time.LocalTime;

@Data
public class PostDto {

    private String contentDetail;

    private LocalTime postTime;

    private int UserId;
}
