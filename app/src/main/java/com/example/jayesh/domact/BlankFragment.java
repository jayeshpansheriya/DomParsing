package com.example.jayesh.domact;


import android.os.Bundle;
import android.os.StrictMode;
import android.test.ViewAsserts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class BlankFragment extends android.app.Fragment {

    StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
ListView lv;
    ArrayList arrayList;
    URL url;
    public BlankFragment() {
        // Required empty public constructo
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_blank,container,false);
        lv=(ListView)container.findViewById(R.id.list);
        arrayList=new ArrayList();

        StrictMode.setThreadPolicy(policy);

        try {

            url=new URL("http://www.androidbegin.com/tutorial/XMLParseTutorial.xml");
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document document=builder.parse(url.openStream());
            document.normalize();

            NodeList list=document.getElementsByTagName("item");
            for (int i=0;i<list.getLength();i++)
            {
                Node node=list.item(0);
                Element element=(Element) node;
                String title=getDatadom(element,"title");
                String desc=getDatadom(element,"description");
                String link=getDatadom(element,"link");
                String date=getDatadom(element,"date");

                String d=title+"\n"+desc+"\n"+link+"\n"+date;
                arrayList.add(d);
            }

            ArrayAdapter adapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,arrayList);
            lv.setAdapter(adapter);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
return view;
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_blank, container, false);


    }
   public String getDatadom(Element element,String s){
       NodeList list1=element.getElementsByTagName(s);
       Node node=list1.item(0);
       Element element1=(Element) node;
       String s1=element1.getTextContent();
       return s1;
   }
}
