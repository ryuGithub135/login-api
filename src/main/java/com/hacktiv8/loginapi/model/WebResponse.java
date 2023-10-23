package com.hacktiv8.loginapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebResponse<T> { //<>generic class karna data selalu berubah ubah

    private T data;

    private String errors;

//    private PagingResponse paging;
}
