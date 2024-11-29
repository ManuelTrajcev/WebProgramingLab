package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;

@AllArgsConstructor
@Data
public class Price {
    private double price;
    private String currency;
}

