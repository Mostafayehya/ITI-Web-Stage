package eg.gov.iti.jets.mappers;

import eg.gov.iti.jets.exceptions.ResourceNotFoundException;
import eg.gov.iti.jets.models.ErrorMessage;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


@Provider
public class ResourceNotFoundExceptionMapper implements ExceptionMapper<ResourceNotFoundException>{

    @Override
    public Response toResponse(ResourceNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 404 , "Sad ): .. Invalid ID");
        errorMessage.setErrorCode(450);
        errorMessage.setErrorDescription("obssss .. mafesh id ");
        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
    }
}
