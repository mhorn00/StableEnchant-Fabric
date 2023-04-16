package xyz.sarcly.stableenchant.screen;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.google.common.collect.Maps;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.NarratorManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.math.random.Random;
import xyz.sarcly.stableenchant.StableEnchant;
import xyz.sarcly.stableenchant.screen.handler.EnchantingTableScreenHandler;

@Environment(value=EnvType.CLIENT)
public class EnchantingTableScreen extends HandledScreen<EnchantingTableScreenHandler> {
	private static final Identifier TEXTURE = new Identifier(StableEnchant.MODID, "textures/gui/container/enchanting_table.png");
	private static final int TEXTURE_WIDTH = 512;
	private static final int TEXTURE_HEIGHT = 512;
	private static final String[] decalWords = {"among us", "amogus", "sus", "minecraft", "based", "cringe", "balls", "of", "wau", "waga", "baba", "bobo", "mh", "lol", "kek", "the", "elder", "scrolls", "klaatu", "berata", "niktu", "xyzzy", "bless", "curse", "light", "darkness", "fire", "air", "earth", "water", "hot", "dry", "cold", "wet", "ignite", "snuff", "embiggen", "twist", "shorten", "stretch", "fiddle", "destroy", "imbue", "galvanize", "enchant", "free", "limited", "range", "of", "towards", "inside", "sphere", "cube", "self", "other", "ball", "mental", "physical", "grow", "shrink", "demon", "elemental", "spirit", "animal", "creature", "beast", "humanoid", "undead", "fresh", "stale", "phnglui", "mglwnafh", "cthulhu", "rlyeh", "wgahnagl", "fhtagn", "baguette"};
	private final Random random = Random.create();
	private HashMap<PageDecalBoarderPos, String> pageTextDecals = Maps.newHashMap();
	private boolean initOpen = false;
	//private final List<IEnchantingTableWidget> widgets = Lists.newArrayList();
	
	public EnchantingTableScreen(EnchantingTableScreenHandler handler, PlayerInventory inv, Text title) {
		super(handler, inv, NarratorManager.EMPTY);
		this.backgroundWidth = 284;
		this.backgroundHeight = 279;
		this.playerInventoryTitleX = this.backgroundWidth - 223;
		this.playerInventoryTitleY = this.backgroundHeight - 94;
	}
	
	@Override
    protected void init() {
		super.init();
		initOpen = true;
		//this.widgets.clear();
	}
	
	@Override
	public void handledScreenTick() {
		super.handledScreenTick();
		//this.widgets.forEach(w -> w.tick());
	}

	@Override
	protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        EnchantingTableScreen.drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight, TEXTURE_WIDTH, TEXTURE_HEIGHT); //Draw base texture
        this.drawPageDecals(matrices, delta, mouseX, mouseY, x, y);
	}
	
	protected void drawPageDecals(MatrixStack matrices, float delta, int mouseX, int mouseY, int backgroundX, int backgroundY) {
		this.drawPageDecalBoarder(matrices, delta, mouseX, mouseY, backgroundX, backgroundY);
	}

	protected void drawPageDecalBoarder(MatrixStack matrices, float delta, int mouseX, int mouseY, int backgroundX, int backgroundY) {
		for (PageDecalBoarderPos pos : PageDecalBoarderPos.values()) {
			matrices.push();
			matrices.translate(backgroundX + pos.xPos, backgroundY + pos.yPos, 0);
			matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(pos.rotation));
			int offset = 0;
			if (initOpen) pageTextDecals.put(pos, chooseDecalText(pos));			
			for (char c : pageTextDecals.get(pos).toCharArray()) {
				EnchantingDecalGlyphs ch = EnchantingDecalGlyphs.getFromChar(c);
				matrices.translate(offset, 0, 0);
				EnchantingTableScreen.drawTexture(matrices, 0, 0, ch.getUPos(), ch.getVPos(), ch.width, ch.height, TEXTURE_WIDTH, TEXTURE_HEIGHT);
				offset = ch.width+1;	
			}
			matrices.pop();
		}
		if (initOpen) initOpen = false;
	}
	
	private String chooseDecalText(PageDecalBoarderPos pos) {
		StringBuilder out = new StringBuilder();
		int curWidth = 0;
		int tries = 0;
		EnchantingDecalGlyphs prev = null;
		while (curWidth != pos.maxWidth) {
            EnchantingDecalGlyphs glyph = Util.getRandom(EnchantingDecalGlyphs.values(), this.random);
            if (glyph == prev) continue;
            if (curWidth + glyph.width <= pos.maxWidth) {
            	out.append(glyph.character);
            	curWidth += glyph.width+1;
            }else if (curWidth + glyph.width > pos.maxWidth && tries > 20) {
            	curWidth -= EnchantingDecalGlyphs.getFromChar(out.charAt(out.toString().length()-1)).width+1;
            	out.deleteCharAt(out.toString().length()-1);
            	tries = 0;
            }
            prev = glyph;
            tries++;
        }
		StableEnchant.LOGGER.info("SUCCESS ON "+out.toString().trim()+"||"+pos.maxWidth+"<"+curWidth);
		return out.toString().trim();
	}

	@Override
    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
		super.drawForeground(matrices, mouseX, mouseY);
	}
	
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
    
    private <T extends ClickableWidget> void addWidget(T widget) {
        this.addDrawableChild(widget);
        //this.widgets.add(widget);
    }

    private static enum EnchantingDecalGlyphs {
    	A(4,5,1,1,'a'),
    	B(4,5,7,1,'b'),
    	C(2,5,13,1,'c'),
    	D(5,5,19,1,'d'),
    	E(4,5,25,1,'e'),
    	F(5,3,31,1,'f'),
    	G(2,5,37,1,'g'),
    	H(3,5,43,1,'h'),
    	I(1,5,49,1,'i'),
    	J(1,5,55,1,'j'),
    	K(5,5,61,1,'k'),
    	L(3,5,67,1,'l'),
    	M(4,5,73,1,'m'),
    	N(4,5,1,7,'n'),
    	O(3,5,7,7,'o'),
    	P(3,5,13,7,'p'),
    	Q(3,5,19,7,'q'),
    	R(3,5,25,7,'r'),
    	S(2,5,31,7,'s'),
    	T(4,5,37,7,'t'),
    	U(5,4,43,7,'u'),
    	V(3,5,49,7,'v'),
    	W(3,5,55,7,'w'),
    	X(4,5,61,7,'x'),
    	Y(3,5,67,7,'y'),
    	Z(3,5,73,7,'z');
    	
    	private final int baseUPos = 286;
    	private final int baseVPos = 0;
    
    	public final int width;
    	public final int height;
    	private final int uPos;
    	private final int vPos;
    	public final char character;
    	
    	private EnchantingDecalGlyphs(int width, int height, int uPos, int vPos, char character) {
			this.width = width;
			this.height = height;
			this.uPos = uPos;
			this.vPos = vPos;
			this.character = character;
		}
    	
    	public static EnchantingDecalGlyphs getFromChar(char character) {
    		//this is stupid im sorry
    		switch (character) {
			case 'a':
			case 'A': return A;
			case 'b':
			case 'B': return B;
			case 'c':
			case 'C': return C;
			case 'd':
			case 'D': return D;
			case 'e':
			case 'E': return E;
			case 'f':
			case 'F': return F;
			case 'g':
			case 'G': return G;
			case 'h':
			case 'H': return H;
			case 'i':
			case 'I': return I;
			case 'j':
			case 'J': return J;
			case 'k':
			case 'K': return K;
			case 'l':
			case 'L': return L;
			case 'm':
			case 'M': return M;
			case 'n':
			case 'N': return N;
			case 'o':
			case 'O': return O;
			case 'p':
			case 'P': return P;
			case 'q':
			case 'Q': return Q;
			case 'r':
			case 'R': return R;
			case 's':
			case 'S': return S;
			case 't':
			case 'T': return T;
			case 'u':
			case 'U': return U;
			case 'v':
			case 'V': return V;
			case 'w':
			case 'W': return W;
			case 'x':
			case 'X': return X;
			case 'y':
			case 'Y': return Y;
			case 'z':
			case 'Z': return Z;
			default: return A;
			}
    	}
    	
    	public static int getTextWidth(String str) {
    		int width = 0;
    		for (char c : str.toCharArray()) {
    			width += getFromChar(c).width;
    		}
    		return width;
    	}
    	
    	public int getUPos() {
    		return this.baseUPos + this.uPos;
    	}
    	
    	public int getVPos() {
    		return this.baseVPos + this.vPos;
    	}
    }
    
    private static enum PageDecalBoarderPos {
    	LeftTop(23,10,0f,115),
    	RightTop(147,10,0f,115),
    	RightSide(269,18,90f,143),
    	BottomRight(261,168,180f,115),
    	BottomLeft(137,168,180f,115),
    	LeftSide(15,160,270f,143);
    	
    	public final int xPos;
    	public final int yPos;
    	public final float rotation;
    	public final int maxWidth;
    	
    	private PageDecalBoarderPos(int x, int y, float rotation, int maxWidth) {
    		this.xPos = x;
    		this.yPos = y;
    		this.rotation = rotation;
    		this.maxWidth = maxWidth;
    	}
    }
}
