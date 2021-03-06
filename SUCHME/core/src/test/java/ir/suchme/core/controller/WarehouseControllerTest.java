package ir.suchme.core.controller;

import ir.suchme.common.dto.product.RequestSearchProductDTO;
import ir.suchme.common.dto.product.ResponseSearchProductDTO;
import ir.suchme.core.controller.base.BaseControllerTest;
import ir.suchme.core.domain.entity.Component;
import ir.suchme.core.domain.entity.Product;
import ir.suchme.core.domain.entity.Supplier;
import ir.suchme.core.domain.entity.enums.ProductType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WarehouseControllerTest extends BaseControllerTest {

    @Test
    public void testSearch(){
/*        given(productRepository.findAllByNameLike(any(String.class))).willReturn(mockProducts());
        ResponseEntity<ResponseSearchProductDTO> responseEntity =
                restTemplate.postForEntity("/search/product",mockReqProdSearchDTO(), ResponseSearchProductDTO.class);
        ResponseSearchProductDTO client = responseEntity.getBody();
        System.out.println(responseEntity.toString());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("0", client.getResponseCode());
        assertEquals(true,responseEntity.getBody().getProductDTOS().get(0).getName()!=null);*/
    }

    private Supplier mockSupplier()
    {
        Supplier s = new Supplier("tamin");
        s.setCreated(new Date());
        s.setId(UUID.randomUUID());
        s.setDeleted(false);
        return s;
    }

    private Set<Component> mockComponents()
    {
        Component component = new Component();
        component.setName("c1");
        HashSet<Component> out = new HashSet<>();
        out.add(component);
        return out;
    }

    private RequestSearchProductDTO mockReqProdSearchDTO(){
        RequestSearchProductDTO req=new RequestSearchProductDTO();
        req.setName("hooooooly");
        return req;
    }
}
