package com.blog.blogappapiutlimate.Exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFondException extends RuntimeException {
    String resourceName;
    String fieldName;
    Integer fieldValue ;



    public ResourceNotFondException( String resourceName, String fieldName, Integer fieldValue) {
        super (String.format ("%s not fond with %s : %d",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }


}
