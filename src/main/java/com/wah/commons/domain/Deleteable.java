package com.wah.commons.domain;

import java.util.Date;

public interface Deleteable{

    Boolean getIsDelete();

    void setIsDelete(Boolean isDelete);

    Date getDeleteTime();

    void setDeleteTime(Date deleteTime);
}
