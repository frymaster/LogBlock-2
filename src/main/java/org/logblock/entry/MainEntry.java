package org.logblock.entry;

import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.logblock.Action;
import org.logblock.LogBlock;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MainEntry extends AbstractEntry
{

    private Action action;
    private Date date;
    private int playerId;
    private int from;
    private byte fromData;
    private int to;
    private byte toData;
    private int x;
    private int y;
    private int z;
    //
    private List<AbstractEntry> children;
    private PlayerEntry player;

    public MainEntry(int id, Action action, Date date, int playerId, int from, byte fromData, int to, byte toData, int x, int y, int z)
    {
        super(id);
        this.action = action;
        this.date = date;
        this.playerId = playerId;
        this.from = from;
        this.fromData = fromData;
        this.to = to;
        this.toData = toData;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public PlayerEntry getPlayer()
    {
        return (player == null) ? player = LogBlock.getInstance().getPlayer(playerId) : player;
    }

    public List<AbstractEntry> getChildren()
    {
        return (children == null) ? children = LogBlock.getInstance().getChildren(this) : children;
    }
}
