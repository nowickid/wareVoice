package pl.dd.warevoice.usecase;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.context.WebApplicationContext;
import pl.dd.warevoice.port.PersistenceOperationsOutputPort;
import pl.dd.warevoice.port.WarehouseManagementInputPort;
import pl.dd.warevoice.presenter.RestPresenter;


@Configuration
public class UseCaseConfig {

    @Bean
    @Scope(WebApplicationContext.SCOPE_REQUEST)
    public WarehouseManagementInputPort enrollStudentUseCase(PersistenceOperationsOutputPort persistenceOps,
                                                             HttpServletResponse httpServletResponse,
                                                             MappingJackson2HttpMessageConverter jackson2HttpMessageConverter) {
        return new WarehouseManagementUseCase(new RestPresenter(httpServletResponse, jackson2HttpMessageConverter), persistenceOps);
    }

}
