package mk.ukim.finki.wp.lab.model;

import org.springframework.core.convert.converter.Converter;

public class StringToPriceConverter implements Converter<String, Price> {

    @Override
    public Price convert(String from) {
        String[] data = from.split(" ");
        return new Price(Double.parseDouble(data[0]), data[1]);
    }
}
