import { createContext, useState } from "react";

const AuthContext = createContext({
    auth: { isAuthenticated: false }, // Cung cấp giá trị mặc định
    setAuth: () => { }, // Giá trị mặc định cho setAuth
});

export const AuthProvider = ({ children }) => {
    const [auth, setAuth] = useState({
        isAuthenticated: false, // Mặc định người dùng chưa đăng nhập
    });

    return (
        <AuthContext.Provider value={{ auth, setAuth }}>
            {children}
        </AuthContext.Provider>
    );
}



export default AuthContext;
