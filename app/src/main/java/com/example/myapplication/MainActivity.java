package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
// ССылки на поля ввода
    EditText fio;
    EditText phone;
    EditText adress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Метод открытия диалогового окна-подсказки открывает диалоговое коно с заголовком title и текстом message
    public void AlertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    // Проверка полей при нажатии кнопки "Оформить заказ"
    public void OnArrange(View view) {
        // ноходим поля по их id и привязываем их значения к переменным
        fio = findViewById(R.id.fio);
        phone = findViewById(R.id.phone);
        adress = findViewById(R.id.adress);
        // проверяем поля

        if (fio.getText().length() == 0)//если полу фио пустое выводим сообщение
            AlertDialog("Уведомление", "Пожалуйста, укажите Ваши ФИО.");
        else if (phone.getText().length() == 0)//если полу номер пустое выводим сообщение
            AlertDialog("Уведомление", "Пожалуйста, укажите номер телефона.");
        else if (adress.getText().length() == 0)//если полу адрес пустое выводим сообщение
            AlertDialog("Уведомление", "Пожалуйста, укажите адрес доставки.");
        else // если все поля заполнены выводим "Заказ оформлен"
            AlertDialog("Уведомление", "Заказ оформлен.");
    }
}
