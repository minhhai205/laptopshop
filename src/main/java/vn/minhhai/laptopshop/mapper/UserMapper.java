package vn.minhhai.laptopshop.mapper;

import org.mapstruct.Mapper;

import vn.minhhai.laptopshop.domain.User;
import vn.minhhai.laptopshop.dto.RegisterDTO;

@Mapper(componentModel = "spring")
public class UserMapper {
    public User registerDTOtoUser(RegisterDTO registerDTO) {
        User user = new User();
        user.setFullName(registerDTO.getName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());

        return user;
    }
}
