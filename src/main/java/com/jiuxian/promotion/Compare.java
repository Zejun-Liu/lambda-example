/*
 * Copyright (c) 2011-2020, baomidou (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.jiuxian.promotion;

import java.io.Serializable;

/**
 * 查询条件封装
 * <p>比较值</p>
 * @author hubin miemie HCL
 * @since 2017-05-26
 */
public interface Compare<R, Children> extends Serializable {

    Children eq(R column, Object val);

    Children ge(R column, Object val);

    Children le(R column, Object val);
}
