package charts;

/**
 * Created by Manel on 11/02/2016.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class Chart extends WebView {
    String title, url, tag;
    int width, height;

    String name1, name2, name3; //ATRIBUTO DE NOMBRE PARA UN VALOR.
    int num1, num2, num3; //ATRIBUTO NUMÉRICO PARA UN VALOR.

    public Chart(Context context) {
        super(context);
    }

    public Chart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Chart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Editar este método para hacer que concuerde con el número de atributos existentes.
     * @param width //Recomendado 300.
     * @param height //Recomendado 300.
     * @param title //Título del Chart.
     * @param url //Dirección web donde se encuentra.
     * @param tag //Tag mediante el que se accederá con JavaScript desde la web.
     *
     * //Atributos:
     * @param name1
     * @param name2
     * @param name3
     * @param value1
     * @param value2
     * @param value3
     */
    public void create(int width, int height, String title, String url, String tag, String name1, String name2, String name3, int value1,  int value2,int value3) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.url = url;
        this.tag = tag;

        /**
         * Asignar cada valor con su atributo.
         */
        this.name1 = name1;
        this.num1 = value1;

        this.name2 = name2;
        this.num2 = value2;

        this.name3 = name3;
        this.num3 = value3;

        //No tocar.
        this.addJavascriptInterface(new WebAppInterface(), tag);
        this.getSettings().setJavaScriptEnabled(true);
        this.loadUrl(url);
    }

    public class WebAppInterface {

        /**
         * Nombre de elemento. Hacer tantos como atributos de nombre hayan.
         * @return
         */
        @JavascriptInterface
        public String getName1() {

            return name1;
        }
        @JavascriptInterface
        public String getName2() {
            return name2;
        }
        @JavascriptInterface
        public String getName3() {
            return name3;
        }



        /**
         * Valor numérico del elemento. Hacer tanto como atributos numéricos hayan.
         * @return
         */
        @JavascriptInterface
        public int getNum1() {
            return num1;
        }

        @JavascriptInterface
        public int getNum2() {
            return num2;
        }

        @JavascriptInterface
        public int getNum3() {
            return num3;
        }

        //Opciones.
        @JavascriptInterface
        public String getTitle() {
            return title;
        }

        @JavascriptInterface
        public int getWidth() {
            return width;
        }

        @JavascriptInterface
        public int getHeight() {
            return height;
        }
    }
}
