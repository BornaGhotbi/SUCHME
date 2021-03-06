package ir.suchme.core.controller;

import ir.suchme.common.dto.component.RequestSearchComponentDTO;
import ir.suchme.common.dto.component.ResponseSearchComponentDTO;
import ir.suchme.common.dto.product.RequestSearchProductDTO;
import ir.suchme.common.dto.product.ResponseSearchProductDTO;
import ir.suchme.common.dto.supplier.RequestSearchSupplierDTO;
import ir.suchme.common.dto.supplier.ResponseSearchSupplierDTO;
import ir.suchme.core.component.UserLoggingComponent;
import ir.suchme.core.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("search")
public class SearchController {

    private final SearchService searchService;
    private final UserLoggingComponent userLoggingComponent;


    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    public SearchController(SearchService searchService, UserLoggingComponent userLoggingComponent) {
        this.searchService = searchService;
        this.userLoggingComponent = userLoggingComponent;
    }

    @RequestMapping( method = RequestMethod.POST,value = "/component")
    public ResponseSearchComponentDTO searchComponent(@RequestBody RequestSearchComponentDTO dto) {
        userLoggingComponent.logUserActivity(SecurityContextHolder.getContext().getAuthentication().getName(),getClass().getSimpleName(),new Object(){}.getClass().getEnclosingMethod().getName(),dto);
        long startTime = System.currentTimeMillis();
        ResponseSearchComponentDTO response =new ResponseSearchComponentDTO();
        try {
            dto.validation();
            response = searchService.searchComponent(dto);
            LOG.info("search : Success | Code: {}", response.getResponseCode());
            return response;
        } catch (Exception|AssertionError e) {
            long finishTime = System.currentTimeMillis();
            response.setError(e.getMessage());
            response.setResponseCode("-1");
            LOG.error("search : Failed | finished in {} ms", String.valueOf(TimeUnit.MILLISECONDS.toMillis(finishTime - startTime)), e);
            return response;
        }
    }
    @RequestMapping( method = RequestMethod.POST,value = "/product")
    public ResponseSearchProductDTO searchProduct(@RequestBody RequestSearchProductDTO dto) {
        userLoggingComponent.logUserActivity(SecurityContextHolder.getContext().getAuthentication().getName(),getClass().getSimpleName(),new Object(){}.getClass().getEnclosingMethod().getName(),dto);
        long startTime = System.currentTimeMillis();
        ResponseSearchProductDTO response =new ResponseSearchProductDTO();
        try {
            dto.validation();
            response = searchService.searchProduct(dto);
            LOG.info("search : Success | Code: {}", response.getResponseCode());
            return response;
        } catch (Exception|AssertionError e) {
            long finishTime = System.currentTimeMillis();
            response.setError(e.getMessage());
            response.setResponseCode("-1");
            LOG.error("search : Failed | finished in {} ms", String.valueOf(TimeUnit.MILLISECONDS.toMillis(finishTime - startTime)), e);
            return response;
        }
    }

    @RequestMapping( method = RequestMethod.POST,value = "/supplier")
    public ResponseSearchSupplierDTO searchSupplier(@RequestBody RequestSearchSupplierDTO dto) {
        userLoggingComponent.logUserActivity(SecurityContextHolder.getContext().getAuthentication().getName(),getClass().getSimpleName(),new Object(){}.getClass().getEnclosingMethod().getName(),dto);
        long startTime = System.currentTimeMillis();
        ResponseSearchSupplierDTO response =new ResponseSearchSupplierDTO();
        try {
            dto.validation();
            response = searchService.searchSupplier(dto);
            LOG.info("search : Success | Code: {}", response.getResponseCode());
            return response;
        } catch (Exception|AssertionError e) {
            long finishTime = System.currentTimeMillis();
            response.setError(e.getMessage());
            response.setResponseCode("-1");
            LOG.error("search : Failed | finished in {} ms", String.valueOf(TimeUnit.MILLISECONDS.toMillis(finishTime - startTime)), e);
            return response;
        }
    }
}
