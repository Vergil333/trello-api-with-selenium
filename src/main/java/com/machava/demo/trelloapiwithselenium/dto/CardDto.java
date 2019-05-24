package com.machava.demo.trelloapiwithselenium.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CardDto {
    public Long id;
    public String name;
    public String url;
}
