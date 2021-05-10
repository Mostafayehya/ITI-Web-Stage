package spring.security.services;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

// todo
@Component("helloService")
public interface HelloService {
    //    @Secured(value = {"ROLE_USER"})
//    @Secured("IS_AUTHENTICATED_ANONYMOUSLY") // ?
//    @Secured("IS_AUTHENTICATED_REMEMBERED") // any login will do
//    @Secured("IS_AUTHENTICATED_FULLY") // remember me login isn't enough
//    @PermitAll // open
    @RolesAllowed("USER")
//    @PreAuthorize("permitAll()")
//    @PreAuthorize("hasAnyRole('USER')")
//    @PreAuthorize("hasAuthority('USER') and #msg.length()>0")
//    @UserOnly
//    @PostAuthorize("#msg.equals(returnObject.toString())")
//    @PreAuthorize("#msg.equals('user here')")
//    @PostAuthorize("returnObject.equals('user here')")
    String userAccess(String msg);

    //    @Secured(value = {"ROLE_ADMIN"})
    @RolesAllowed({"ADMIN"})
//    @PreAuthorize("hasAnyRole('ADMIN')")
//    @PreAuthorize("hasAnyRole('ADMIN')")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    @AdminOnly
    String adminAccess(String msg);
}
