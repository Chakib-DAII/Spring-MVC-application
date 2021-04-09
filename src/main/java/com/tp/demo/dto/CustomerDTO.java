package com.tp.demo.dto;

import com.tp.demo.dao.entities.Customer;
import lombok.Data;

/**
 * Data Transfer Object :
 * It's a representation for our entity.
 *
 * Note: When using DTO objects, we certainly need to introduce 2 methods called "MappingMethods"
 *       used in order to transform an entity to a DTO and a DTO to an entity
 */
@Data
public class CustomerDTO {

    private Long id;
    private String firstName;
    private String lastName;


    /**
     * Maps an entity object to a DTO object
     * @param entity source
     * @return a DTO containing the values acquired from the entity
     */
    public static CustomerDTO fromEntityToDto(Customer entity) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        return dto;
    }

    /**
     * Maps a DTO object to an entity object
     * @param dto source
     * @return an entity containing the values acquired from the DTO
     */
    public static Customer fromDtoToEntity(CustomerDTO dto) {
        Customer entity = new Customer();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        return entity;
    }
}
