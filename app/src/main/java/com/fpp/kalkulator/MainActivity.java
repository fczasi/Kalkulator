package com.fpp.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    float liczba;
    float liczba2;
    float wynik;
    char znak;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ce(View view){
        TextView okno = findViewById(R.id.okienko);
        TextView maleokno = findViewById(R.id.maleokinko);

        okno.setText("");
        maleokno.setText("");

        // usuwanie wszystkich znakow z pola tekstowego
    }

    public void backspace(View view){
        TextView okno = findViewById(R.id.okienko);

        String zawartosc = okno.getText().toString();

        if(!zawartosc.equals("")){
            zawartosc = zawartosc.substring(0, zawartosc.length()-1);

        }
        okno.setText(zawartosc);
        // usuwanie ostatniego znaku z pola tekstowego
    }

    public void procent(View view){

    }

    public void przezx(View view){
        TextView okno = findViewById(R.id.okienko);
        zOkna();
        if(liczba != 0){
            float przezliczbe = 1/liczba;
            okno.setText(przezliczbe+"");
        }
        // wyswietlany jest wynik dzielenia jedynki przez liczbe z pola tekstowego
    }

    public void pierwiastkowanie(View view){
        TextView okno = findViewById(R.id.okienko);
        zOkna();
        double pierwiastek = Math.sqrt(liczba);
        okno.setText(pierwiastek+"");

        // liczba z pola tekstowego jest pierwiastkowana i wyswietlana
    }

    public void sqr(View view){
        TextView okno = findViewById(R.id.okienko);

        zOkna();
        float potega = liczba * liczba;
        okno.setText(potega+"");

        // liczba z pola tekstowego jest mnozona przez siebie i wyswietlana
    }

    public void dzielenie(View view){
        TextView okno = findViewById(R.id.okienko);
        TextView maleokno = findViewById(R.id.maleokinko);

        zOkna();
        znak = '/';// ustawienie znaku na dzielenie
        maleokno.setText(liczba+" /");
        okno.setText("");

        blokowanie();
    }

    public void siedem(View view){// liczba siedem
        TextView okno = findViewById(R.id.okienko);
        String weztekst = okno.getText().toString();
        okno.setText(weztekst + "7");

        odblokowanie();
    }

    public void osiem(View view){// liczba osiem
        TextView okno = findViewById(R.id.okienko);
        String weztekst = okno.getText().toString();
        okno.setText(weztekst + "8");

        odblokowanie();
    }

    public void dziewiec(View view){// liczba dziewiec
        TextView okno = findViewById(R.id.okienko);
        String weztekst = okno.getText().toString();
        okno.setText(weztekst + "9");

        odblokowanie();
    }

    public void mnozenie(View view){
        TextView okno = findViewById(R.id.okienko);
        TextView maleokno = findViewById(R.id.maleokinko);

        zOkna();
        znak = '*';// ustawienie znaku na mnozenie(razy)
        maleokno.setText(liczba+" *");// dodanie znaku mnozenia do pola tekstowego
        okno.setText("");
    }

    public void cztery(View view){// liczba cztery
        TextView okno = findViewById(R.id.okienko);
        String weztekst = okno.getText().toString();
        okno.setText(weztekst + "4");

        odblokowanie();
    }

    public void piec(View view){// liczba piec
        TextView okno = findViewById(R.id.okienko);
        String weztekst = okno.getText().toString();
        okno.setText(weztekst + "5");

        odblokowanie();
    }

    public void szesc(View view){// liczba szesc
        TextView okno = findViewById(R.id.okienko);
        String weztekst = okno.getText().toString();
        okno.setText(weztekst + "6");

        odblokowanie();
    }

    public void odejmowanie(View view){
        TextView okno = findViewById(R.id.okienko);
        TextView maleokno = findViewById(R.id.maleokinko);

        String zawartosc = okno.getText().toString();

        if(zawartosc == ""){
            okno.setText("-");
        }else{
            znak = '-';// ustawiony znak na minus

            zOkna();
            maleokno.setText(liczba+" -");// dodanie znaku odejmowanie do pola tekstoweo
            okno.setText("");
        }



    }


    public void jeden(View view){//liczba jeden
        TextView okno = findViewById(R.id.okienko);
        String weztekst = okno.getText().toString();
        okno.setText(weztekst + "1");//dodanie jedynki do pola tekstowego
        odblokowanie();// odblokowanie zera, jesli zablokowane
    }

    public void dwa(View view){//liczba dwa
        TextView okno = findViewById(R.id.okienko);
        String weztekst = okno.getText().toString();
        okno.setText(weztekst + "2");
        odblokowanie();

    }

    public void trzy(View view){// liczba trzy
        TextView okno = findViewById(R.id.okienko);
        String weztekst = okno.getText().toString();
        okno.setText(weztekst + "3");//
        odblokowanie();
    }

    public void dodawanie(View view){
        TextView okno = findViewById(R.id.okienko);
        TextView maleokno = findViewById(R.id.maleokinko);

        zOkna();
        znak = '+';// ustawienie znaku na dodawanie
        maleokno.setText(liczba+" +");// dodanie plusa do pola tekstowego
        okno.setText("");


    }

    public void plusminus(View view){
        TextView okno = findViewById(R.id.okienko);
        zOkna();
        liczba = -liczba;//zmiana znaku na przeciwny
        okno.setText(liczba+"");
    }

    public void zero(View view){// liczba zero
        TextView okno = findViewById(R.id.okienko);
        String weztekst = okno.getText().toString();
        okno.setText(weztekst + "0");
    }

    public void kropka(View view){ // znak kropka
        TextView okno = findViewById(R.id.okienko);

        String weztekst = okno.getText().toString();

        okno.setText(weztekst + ".");//dodanie kropki do pola tekstowego

    }

    public void rownasie(View view){ // wykonanie dzialania
        TextView okno = findViewById(R.id.okienko);
        TextView maleokno = findViewById(R.id.maleokinko);

        liczba2 = Float.parseFloat(okno.getText().toString());// zapisanie drugiej liczby do zmiennej


        switch (znak){
            case '+':
                maleokno.setText(liczba+" + "+liczba2);
                wynik = liczba + liczba2;// jesli dodawanie to dodaj
                break;

            case '-':
                maleokno.setText(liczba+" - "+liczba2);
                wynik = liczba - liczba2;// jesli odejmowanie to odejmij
                break;

            case '*':
                maleokno.setText(liczba+" * "+liczba2);
                wynik = liczba * liczba2;// jesli mnozenie to pomnoz
                break;

            case '/':
                maleokno.setText(liczba+" / "+liczba2);
                wynik = liczba / liczba2;// jesli dzielenie to podziel
                break;

            default:
                    wynik = liczba;
        }


        okno.setText(wynik+"");// wyswietlenie wyniku
    }

    public void zOkna(){
        TextView okno = findViewById(R.id.okienko);
        if(okno.getText() != ""){
            liczba = Float.parseFloat(okno.getText().toString());
        }

    }

    public void blokowanie(){ // blokowanie przycisku zero podczas dzielenia
        Button zeroGuzik = findViewById(R.id.zero);
        zeroGuzik.setEnabled(false);

    }

    public void odblokowanie(){ // odblokowanie przycisku zero po dzieleniu
        Button zeroGuzik = findViewById(R.id.zero);
        zeroGuzik.setEnabled(true);
    }

}