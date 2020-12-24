package com.wah.commons.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
public class Entity{

    private String id;

    @Override
    public boolean equals(Object compare){
        if(this == compare){
            return true;
        }

        if(this.getClass() == compare.getClass()){
            Entity entity = (Entity) compare;

            if(StringUtils.isNotBlank(this.id)){
                return this.id.equals(entity.id);
            }
        }

        return false;
    }

    @Override
    public int hashCode(){
        return StringUtils.isBlank(id) ? 0 : id.hashCode();
    }

    @Override
    public String toString(){
//        return GsonUtils.serialize(this);
        return "";
    }
}
