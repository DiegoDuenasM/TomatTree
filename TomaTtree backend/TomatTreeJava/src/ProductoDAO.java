import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductoDAO {

    // 1. CREATE (Insertar un nuevo producto en TomatTree)
    public void insertarProducto(String nombre, String tipo, String unidadMedida, double stockSutatenza, double stockBogota) {
        String sql = "INSERT INTO Producto (nombre, tipo, unidad_medida, stock_sutatenza, stock_bogota) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, tipo); // ej. 'fruta_fresca'
            pstmt.setString(3, unidadMedida); // ej. 'kg'
            pstmt.setDouble(4, stockSutatenza);
            pstmt.setDouble(5, stockBogota);

            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                System.out.println("¡Producto registrado con éxito en TomatTree!");
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar el producto: " + e.getMessage());
        }
    }

    // 2. READ (Consultar y listar todos los productos de la base de datos)
    public void listarProductos() {
        String sql = "SELECT id_producto, nombre, tipo, stock_sutatenza, stock_bogota FROM Producto";

        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- LISTADO DE INVENTARIO TOMATTREE ---");
            while (rs.next()) {
                int id = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                double stockSutatenza = rs.getDouble("stock_sutatenza");
                double stockBogota = rs.getDouble("stock_bogota");

                System.out.println("ID: " + id + " | Producto: " + nombre + " (" + tipo + ") " +
                                   "| Sutatenza: " + stockSutatenza + " kg | Bogotá: " + stockBogota + " kg");
            }
            System.out.println("-----------------------------------------\n");

        } catch (SQLException e) {
            System.out.println("Error al consultar los productos: " + e.getMessage());
        }
    }

    // 3. UPDATE (Actualizar los stocks de un producto)
    public void actualizarProducto(int idProducto, double stockSutatenza, double stockBogota) {
        String sql = "UPDATE Producto SET stock_sutatenza = ?, stock_bogota = ? WHERE id_producto = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setDouble(1, stockSutatenza);
            pstmt.setDouble(2, stockBogota);
            pstmt.setInt(3, idProducto);

            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                System.out.println("¡Producto actualizado con éxito en TomatTree!");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
        }
    }

    // 4. DELETE (Eliminar un producto por su ID)
    public void eliminarProducto(int idProducto) {
        String sql = "DELETE FROM Producto WHERE id_producto = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, idProducto);

            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                System.out.println("¡Producto eliminado con éxito de TomatTree!");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        }
    }

    // Método principal para probar el CRUD
    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();

        // Probamos consultando los productos de la base de datos
        productoDAO.listarProductos();
    }
}