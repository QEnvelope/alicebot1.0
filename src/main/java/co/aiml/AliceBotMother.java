package co.aiml;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.Context;
import bitoflife.chatterbean.parser.AliceBotParser;
import bitoflife.chatterbean.util.Searcher;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class AliceBotMother
{
  
  private ByteArrayOutputStream gossip;
  
  
  public void setUp()
  {
    gossip = new ByteArrayOutputStream();
  }
  
  public String gossip()
  {
    return gossip.toString();
  }

  public AliceBot newInstance() throws Exception
  {
    Searcher searcher = new Searcher();
    AliceBotParser parser = new AliceBotParser();
    AliceBot bot = parser.parse(new FileInputStream("alicebot/Bots/context.xml"),
                                new FileInputStream("alicebot/Bots/splitters.xml"),
                                new FileInputStream("alicebot/Bots/substitutions.xml"),
                                searcher.search("alicebot/Bots/mydomain", ".*\\.aiml"));

    Context context = bot.getContext();
    context.outputStream(gossip);
    return bot;
  }
}
