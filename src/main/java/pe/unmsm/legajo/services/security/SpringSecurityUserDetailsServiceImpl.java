package pe.unmsm.legajo.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.unmsm.legajo.domain.User;
import pe.unmsm.legajo.services.UserService;

@Service("userDetailService")
public class SpringSecurityUserDetailsServiceImpl implements UserDetailsService {

	private UserService userService;
    private Converter<User, UserDetails> userUserDetailsConverter;
    
    @Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

    @Autowired
    @Qualifier(value="userToUserDetails")
	public void setUserUserDetailsConverter(Converter<User, UserDetails> userUserDetailsConverter) {
		this.userUserDetailsConverter = userUserDetailsConverter;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userUserDetailsConverter.convert(userService.findByUserName(username));
	}

}
