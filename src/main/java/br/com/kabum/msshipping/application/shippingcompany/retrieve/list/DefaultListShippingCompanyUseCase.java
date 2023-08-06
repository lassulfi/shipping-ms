package br.com.kabum.msshipping.application.shippingcompany.retrieve.list;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.kabum.msshipping.domain.shippingcompany.factory.ShippingCompanyFactory;
import br.com.kabum.msshipping.domain.shippingcompany.valueobject.Product;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DefaultListShippingCompanyUseCase extends ListShippingCompanyUseCase {

    @Override
    public List<ShippingCompanyListOutput> execute(ListShippingCompanyCommand aCommand) {
        List<ShippingCompanyListOutput> shippingCompanies = new ArrayList<>();

        final var product = Product.with(aCommand.width(), aCommand.height(), aCommand.weight());

        final var kabum = ShippingCompanyFactory.createKabum();
        kabum.changeProduct(product)
            .calculateValue();

        if (kabum.value() != null) {
            log.info("Success while calculating KaBuM shipping. Adding to list.");
            shippingCompanies.add(ShippingCompanyListOutput.from(kabum));
        }

        final var ninja = ShippingCompanyFactory.createNinja();
        ninja.changeProduct(product)
            .calculateValue();
        
        if (ninja.value() != null) {
            log.info("Success while calculating Ninja shipping. Adding to list.");
            shippingCompanies.add(ShippingCompanyListOutput.from(ninja));
        }

        return shippingCompanies;
    }
    
}
