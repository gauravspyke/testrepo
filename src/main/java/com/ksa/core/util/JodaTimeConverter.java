package com.ksa.core.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class JodaTimeConverter<T> implements com.thoughtworks.xstream.converters.Converter
{

    @SuppressWarnings("unchecked")
    public boolean canConvert( final Class type )
    {
        return DateTime.class.isAssignableFrom( type );
    }


    public void marshal( Object source, HierarchicalStreamWriter writer, MarshallingContext context )
    {
        writer.setValue( source.toString() );
    }


    @SuppressWarnings("unchecked")
    public Object unmarshal( HierarchicalStreamReader reader,
                             UnmarshallingContext context )
    {

		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:Ss.SSSZ");
		DateTime dt = formatter.parseDateTime(reader.getValue());
        return dt;
    }

	}
