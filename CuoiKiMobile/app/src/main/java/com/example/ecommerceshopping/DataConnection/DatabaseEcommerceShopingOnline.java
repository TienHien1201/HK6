package com.example.ecommerceshopping.DataConnection;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ecommerceshopping.Model.CartItem;
import com.example.ecommerceshopping.Model.MenuItem;
import com.example.ecommerceshopping.Model.OrderDetail;
import com.example.ecommerceshopping.Model.PopularItem;
import com.example.ecommerceshopping.Model.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseEcommerceShopingOnline extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "DbEcommerceFood.db";
    private static final int DATABASE_VERSION = 2;

    public DatabaseEcommerceShopingOnline(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Bảng users
        String createUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT UNIQUE, " +
                "password TEXT, " +
                "role TEXT DEFAULT 'user')";
        db.execSQL(createUsersTable);


        // Bảng menu
        String createPopularTable = "CREATE TABLE IF NOT EXISTS popular (" +
                "popular_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "price INTEGER NOT NULL, " +
                "image BLOB)";
        db.execSQL(createPopularTable);


        // Bảng menu
        String createMenuTable = "CREATE TABLE IF NOT EXISTS menu (" +
                "menu_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "price INTEGER NOT NULL, " +
                "image BLOB)";
        db.execSQL(createMenuTable);

        // Bảng cart
        String createCartTable = "CREATE TABLE IF NOT EXISTS cart (" +
                "cart_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "menu_id INTEGER, " +
                "name TEXT NOT NULL, " +
                "price INTEGER NOT NULL, " +
                "image BLOB, " +
                "quality INTEGER NOT NULL DEFAULT 1, " +  // Thêm cột quality
                "FOREIGN KEY(menu_id) REFERENCES menu(menu_id))";
        db.execSQL(createCartTable);

        String createOrderDetailsTable = "CREATE TABLE IF NOT EXISTS order_details (" +
                "order_detail_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "user_id INTEGER, " +
                "product_name TEXT NOT NULL, " +
                "total_price REAL NOT NULL, " +
                "status TEXT CHECK(status IN ('paid', 'unpaid')) NOT NULL, " +
                "image BLOB, " + // Thêm cột image với kiểu BLOB
                "FOREIGN KEY(user_id) REFERENCES users(id))";
        db.execSQL(createOrderDetailsTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS menu");
        db.execSQL("DROP TABLE IF EXISTS cart");
        db.execSQL("DROP TABLE IF EXISTS order_details");
        onCreate(db);
    }

    //############################## User #########################################
    public void insertUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", user.getUsername());
        values.put("password", user.getPassword());
        values.put("role", user.getRole());

        db.insert("users", null, values);
        db.close();
    }
    public User authenticateUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        Cursor cursor = db.rawQuery(query, new String[]{username, password});

        if (cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String role = cursor.getString(cursor.getColumnIndexOrThrow("role"));
            cursor.close();
            db.close();
            return new User(id, username, password, role);
        }

        cursor.close();
        db.close();
        return null; // Không tìm thấy người dùng
    }
    public boolean isAdmin(User user) {
        return "admin".equalsIgnoreCase(user.getRole());
    }

    //###################### MENU TABLE ###############################
    // Thêm dữ liệu vào bảng menu
    public void insertMenuItem(String name, int price, byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("price", price);
        values.put("image", image);

        db.insert("menu", null, values);
        db.close();
    }

    // Lấy toàn bộ dữ liệu từ bảng menu
    public List<MenuItem> getMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM menu", null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("menu_id"));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") int price = cursor.getInt(cursor.getColumnIndex("price"));
                @SuppressLint("Range") byte[] image = cursor.getBlob(cursor.getColumnIndex("image"));
                menuItems.add(new MenuItem(id, name, price, image));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return menuItems;
    }

    // Xóa một mục từ bảng menu
    public void deleteMenuItem(int menuId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("menu", "menu_id = ?", new String[]{String.valueOf(menuId)});
        db.close();
    }

    // Cập nhật một mục trong bảng menu
    public void updateMenuItem(int menuId, String newName, int newPrice, byte[] newImage) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", newName);
        values.put("price", newPrice);
        values.put("image", newImage);

        db.update("menu", values, "menu_id = ?", new String[]{String.valueOf(menuId)});
        db.close();
    }
    //###################### POPULAR TABLE ###############################
    // Thêm dữ liệu vào bảng popular
    public void insertPopularItem(String name, int price, byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("price", price);
        values.put("image", image);

        db.insert("popular", null, values);
        db.close();
    }
    // Lấy toàn bộ dữ liệu từ bảng popular
    public List<PopularItem> getPopularItems() {
        List<PopularItem> popularItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM popular", null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("popular_id"));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") int price = cursor.getInt(cursor.getColumnIndex("price"));
                @SuppressLint("Range") byte[] image = cursor.getBlob(cursor.getColumnIndex("image"));
                popularItems.add(new PopularItem(id, name, price, image));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return popularItems;
    }

    //############################  CART TABLE ###########################################
    // Thêm một mục vào bảng cart
    public void insertCart(int menuId, String name, int price, byte[] image, int quality) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("menu_id", menuId);
        values.put("name", name);
        values.put("price", price);
        values.put("image", image);
        values.put("quality", quality);

        // Chèn dữ liệu vào bảng cart
        db.insert("cart", null, values);
        db.close();
    }
    // Lấy tất cả các mục trong bảng cart
    public List<CartItem> getCart() {
        List<CartItem> cartItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM cart", null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int cartId = cursor.getInt(cursor.getColumnIndex("cart_id"));
                @SuppressLint("Range") int menuId = cursor.getInt(cursor.getColumnIndex("menu_id"));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") int price = cursor.getInt(cursor.getColumnIndex("price"));
                @SuppressLint("Range") byte[] image = cursor.getBlob(cursor.getColumnIndex("image"));
                @SuppressLint("Range") int quality = cursor.getInt(cursor.getColumnIndex("quality"));

                // Thêm mỗi mục vào danh sách cartItems
                cartItems.add(new CartItem(cartId, menuId, name, price, image, quality));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return cartItems;
    }

    public int getCartItemQualityByName(String name) {
        int quality = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT quality FROM cart WHERE name = ?", new String[]{name});
        if (cursor.moveToFirst()) {
            quality = cursor.getInt(0); // Lấy giá trị cột quality
        }
        cursor.close();
        db.close();
        return quality;
    }
    public void updateCartQuality(String name, int newQuality) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("quality", newQuality); // Cập nhật cột quality
        db.update("cart", values, "name = ?", new String[]{name}); // Cập nhật theo tên món ăn
        db.close();
    }
    public void deleteCartItem(int cartId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("cart", "cart_id  = ?", new String[]{String.valueOf(cartId)});
        db.close();
    }
    public void clearCart() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM cart");
        db.close();
    }
    //##########################  BẢNG ORDERDETAIL #####################################
    public boolean insertOrderDetails(int userId, String itemName, double itemPrice, String status, byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // Kiểm tra giá trị itemPrice và đảm bảo nó là hợp lệ
        if (itemPrice <= 0) {
            Log.e("Database", "Price is invalid: " + itemPrice);
            return false; // Nếu giá trị không hợp lệ, trả về false
        }

        // Kiểm tra giá trị status có hợp lệ không
        if (!(status.equals("paid") || status.equals("unpaid"))) {
            Log.e("Database", "Status is invalid: " + status);
            return false; // Nếu status không hợp lệ, trả về false
        }

        values.put("user_id", userId);
        values.put("product_name", itemName);
        values.put("total_price", itemPrice);  // Lưu giá trị với kiểu REAL để hỗ trợ giá trị số lẻ
        values.put("status", status);
        values.put("image", image); // Lưu ảnh dưới dạng mảng byte

        // Chèn dữ liệu vào bảng order_details
        long result = db.insert("order_details", null, values);
        return result != -1; // Trả về true nếu thành công, false nếu không
    }
    public List<OrderDetail> getOrderDetails() {
        List<OrderDetail> orderDetails = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM order_details", null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int orderDetailId = cursor.getInt(cursor.getColumnIndex("order_detail_id"));
                @SuppressLint("Range") int userId = cursor.getInt(cursor.getColumnIndex("user_id"));
                @SuppressLint("Range") String productName = cursor.getString(cursor.getColumnIndex("product_name"));
                @SuppressLint("Range") double totalPrice = cursor.getDouble(cursor.getColumnIndex("total_price")); // Sửa thành double
                @SuppressLint("Range") String status = cursor.getString(cursor.getColumnIndex("status"));
                @SuppressLint("Range") byte[] image = cursor.getBlob(cursor.getColumnIndex("image")); // Lấy ảnh từ cột image

                // Tạo đối tượng OrderDetail và thêm vào danh sách
                orderDetails.add(new OrderDetail(orderDetailId, userId, productName, totalPrice, status, image));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return orderDetails;
    }


    public void clearDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS order_details");
        // Gọi lại hàm tạo bảng
        onCreate(db);
    }

}
