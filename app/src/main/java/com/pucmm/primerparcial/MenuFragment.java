package com.pucmm.primerparcial;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final ArrayList<String> conceptosAndroid = new ArrayList<>();
        conceptosAndroid.add("SDK de Android");
        conceptosAndroid.add("Arquitectura de Android");
        conceptosAndroid.add("Java API Framework");
        conceptosAndroid.add("Android Runtime");
        conceptosAndroid.add("Hardware Abstraction Layer (HAL)");
        conceptosAndroid.add("Kernel de Linux");
        conceptosAndroid.add("Intents");

        final ArrayList<String> definiciones = new ArrayList<>();
        definiciones.add("Provee de herramientas y APIs necesarios para comenzar a desarrollar aplicaciones en a plataforma Android.");
        definiciones.add("Está diseñada para simplificar el re uso de componentes; cualquier aplicación puede publicar sus capacidades y cualquier otra aplicación puede luego hacer uso de esas capacidades sujeto a reglas de seguridad del framework.");
        definiciones.add("Todo el conjunto de funciones del SO Android está disponible mediante API escritas en el lenguaje Java. Estas API son los cimientos que necesitas para crear apps de Android simplificando la reutilización de componentes del sistema y servicios centrales y modulares.");
        definiciones.add("Para los dispositivos con Android 5.0 (nivel de API 21) o versiones posteriores, cada app ejecuta sus propios procesos con sus propias instancias del tiempo de ejecución de Android (ART). El ART está escrito para ejecutar varias máquinas virtuales en dispositivos de memoria baja ejecutando archivos DEX, un formato de código de bytes diseñado especialmente para Android y optimizado para ocupar un espacio de memoria mínimo. Crea cadenas de herramientas, como Jack, y compila fuentes de Java en código de bytes DEX que se pueden ejecutar en la plataforma Android.");
        definiciones.add("La capa de abstracción de hardware (HAL) brinda interfaces estándares que exponen las capacidades de hardware del dispositivo al framework de la Java API de nivel más alto.");
        definiciones.add(" La base de la plataforma Android es el kernel de Linux. Por ejemplo, el tiempo de ejecución de Android (ART) se basa en el kernel de Linux para funcionalidades subyacentes, como la generación de subprocesos y la administración de memoria de bajo nivel.");
        definiciones.add("Un Intent es un objeto de mensajería que puede utilizar para solicitar una acción de otro componente de la aplicación (Activities, Services, Broadcast receivers, Content providers).");

        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, conceptosAndroid);
        ListView listData = (ListView)view.findViewById(R.id.listMenu);
        listData.setAdapter(adapter);
        listData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedData = definiciones.get(i);
                DetailFragment detailFragment = new DetailFragment();

                Bundle bundle = new Bundle();
                bundle.putString("selected_data", selectedData);
                detailFragment.setArguments(bundle);
                FragmentManager manager = getFragmentManager();

                switch (MainActivity.orientation){

                    case 1:
                        manager.beginTransaction().replace(R.id.mainLayout, detailFragment).addToBackStack(null).commit();
                        break;

                    case 2:
                        manager.beginTransaction().replace(R.id.detailLayout, detailFragment).commit();
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + MainActivity.orientation);
                }
            }
        });

        return view;
    }

}