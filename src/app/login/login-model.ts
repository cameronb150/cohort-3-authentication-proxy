export class LoginModel {
    constructor(
        public username: string,
        public password: string
    ) { }

    setUsername(username: string): void {
        this.username = username;
    }
    getUsername(): string {
        return this.username;
    }

    setPassword(password: string): void {
        this.password = password;
    }
    getPassword(): string {
        return this.password;
    }
}