namespace java com.raveland.client

exception BusiException {
    1:optional i32 code,
    2:optional string message
}

enum Gender {
    Male = 1,
    Female = 2
}

struct UserCmd {
    1: string name,
    2: string password,
    3: Gender gender,
}
