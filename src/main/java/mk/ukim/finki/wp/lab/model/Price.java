package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import jakarta.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Price {
    private double price;
    private String currency;
}

