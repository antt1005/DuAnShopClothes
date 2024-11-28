
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import path_name from '~/constants/routers';
// pages
import Login from './pages/Auth/Login';
import Order from './pages/Orders/Order';
import ForgotPassword from './pages/Auth/ForgotPassword';
import { AuthProvider } from './components/AuthContext';
import MainLayout from './layouts/MainLayout';
import Voucher from './pages/Vouchers/Voucher';
import Brand from './pages/Products/Brand';
import Color from './pages/Products/Color';
import Error500 from './pages/Error/Error500';
import Category from './pages/Products/Category';
import Size from './pages/Products/Size';
import Material from './pages/Products/Material';
import Supplier from './pages/Products/Supplier';
import Dashboard from './pages/Dashboard/Dashboard';
import User from './pages/User/User';
import Role from './pages/Role/Role';
import NewSell from './pages/Sell/Sell';
import Error404 from './pages/Error/Error404';
import Error403 from './pages/Error/Error403';
import ChangePassword from './pages/Auth/ChangePassword';
import Sell from './pages/Sell/Sell';
import OrderDetail from './pages/Orders/OrderDetail';
import Product from './pages/Products/Product';
import ProductAdd from './pages/Products/ProductAdd';
import ProductEdit from './pages/Products/ProductEdit';
import ProtectedRoute from "./components/ProtectedRoute";
function App() {

    const router = createBrowserRouter([
        {
            path: path_name.login,
            element: <Login />,
        },
        {
            path: path_name.forgot_password,
            element: <ForgotPassword />,
        },
        {
            path: '/500',
            element: <Error500 />,
        },
        {
            path: '/404',
            element: <Error404 />,
        },
        {
            path: '/403',
            element: <Error403 />,
        },
        {
            element: <MainLayout />,
            children: [
                {
                    path: path_name.dashboard,
                    element: (
                        // <ProtectedRoute>
                        <Dashboard />
                        // </ProtectedRoute>
                    ),
                },
                {
                    path: path_name.product,
                    element: (
                        // <ProtectedRoute>
                        <Product />
                        // </ProtectedRoute>
                    ),
                },
                {
                    path: path_name.brand,
                    element: (
                        <ProtectedRoute>
                            <Brand />
                        </ProtectedRoute>
                    ),
                },
                {
                    path: path_name.color,
                    element: (
                        // <ProtectedRoute>
                        <Color />
                        // </ProtectedRoute>
                    ),
                },
                {
                    path: path_name.category,
                    element: (
                        // <ProtectedRoute>
                        <Category />
                        // </ProtectedRoute>
                    ),
                },
                {
                    path: path_name.supplier,
                    element: (
                        // <ProtectedRoute>
                        <Supplier />
                        // </ProtectedRoute>
                    ),
                },
                {
                    path: path_name.size,
                    element: (
                        // <ProtectedRoute>
                        <Size />
                        // </ProtectedRoute>
                    ),
                },
                {
                    path: path_name.material,
                    element: (
                        // <ProtectedRoute>
                        <Material />
                        // </ProtectedRoute>
                    ),
                },
                {
                    path: path_name.newSell,
                    element: (
                        // <ProtectedRoute>
                        <Sell />
                        // </ProtectedRoute >
                    ),
                },
                {
                    path: path_name.order,
                    element: (
                        // <ProtectedRoute>
                        <Order />
                        // </ProtectedRoute >
                    ),
                },
                {
                    path: path_name.user,
                    element: (
                        // <ProtectedRoute>
                        <User />
                        // </ProtectedRoute >
                    ),
                },
                {
                    path: path_name.role,
                    element: (
                        // <ProtectedRoute>
                        <Role />
                        // </ProtectedRoute >
                    ),
                },
                {
                    path: path_name.voucher,
                    element: (
                        // <ProtectedRoute>
                        <Voucher />
                        // </ProtectedRoute >
                    ),
                },
                {
                    path: path_name.sell + '/:id',
                    element: (
                        // <ProtectedRoute>
                        <Sell />
                        // </ProtectedRoute >
                    ),
                },
                {
                    path: path_name.order_detail + '/:id',
                    element: (
                        // <ProtectedRoute>
                        <OrderDetail />
                        // </ProtectedRoute >
                    ),
                },
                {
                    path: path_name.change_password,
                    element: (
                        // <ProtectedRoute>
                        <ChangePassword />
                        // </ProtectedRoute >
                    ),
                },
                {
                    path: path_name.add_product,
                    element: (
                        // <ProtectedRoute>
                        <ProductAdd />
                        // </ProtectedRoute >
                    ),
                },
                {
                    path: path_name.edit_product + '/:id',
                    element: (
                        // <ProtectedRoute>
                        <ProductEdit />
                        // </ProtectedRoute >
                    ),
                },
            ],

        },
    ]);
    return <RouterProvider router={router} />;
    // <AuthProvider>

    // </AuthProvider>
}

export default App;
