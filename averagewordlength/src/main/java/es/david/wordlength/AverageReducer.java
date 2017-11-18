package es.david.wordlength;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AverageReducer extends Reducer<Text, IntWritable, Text, DoubleWritable> {
	@Override
	protected void reduce(Text pKey, Iterable<IntWritable> pValues, Context pContext)
			throws IOException, InterruptedException {
		float wordCount = 0;
		int n = 0;
		for (IntWritable value : pValues) {
			wordCount += value.get();
			n++;
		}
		pContext.write(pKey, new DoubleWritable(wordCount / n));
	}
}
