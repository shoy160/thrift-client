include "shared.thrift"

namespace java com.raveland.client

service UserService {
    i32 add(1:shared.UserCmd cmd)
}
