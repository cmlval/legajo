package pe.unmsm.legajo.converters;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import pe.unmsm.legajo.domain.User;
import pe.unmsm.legajo.services.security.UserDetailsImpl;

@Component
public class UserToUserDetails implements Converter<User, UserDetails> {

	@Override
	public UserDetails convert(User user) {
		// TODO Auto-generated method stub
		UserDetailsImpl userDetails = new UserDetailsImpl();
        userDetails.setUsername(user.getUsername());
        userDetails.setPassword(user.getEncryptedPassword());
        userDetails.setEnabled(user.getEnabled());

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        });

        userDetails.setAuthorities(authorities);

        return userDetails;
	}

}
