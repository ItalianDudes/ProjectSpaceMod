package com.italiandudes.projectspace.blocks;

import com.italiandudes.projectspace.init.ModTileEntityTypes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import com.italiandudes.projectspace.tileEntity.DebugDisplayCaseTileEntity;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class DebugDisplayCaseBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    //These are the voxelShapes of the custom block.
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(3, 10, 3, 13, 11, 4),
            Block.box(3, 0, 3, 13, 1, 13),
            Block.box(6, 1, 6, 10, 9, 10),
            Block.box(3, 9, 3, 13, 10, 13)
    ).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(3, 10, 12, 13, 11, 13),
            Block.box(3, 0, 3, 13, 1, 13),
            Block.box(6, 1, 6, 10, 9, 10),
            Block.box(3, 9, 3, 13, 10, 13)
    ).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(3, 10, 12, 13, 11, 13),
            Block.box(3, 0, 3, 13, 1, 13),
            Block.box(6, 1, 6, 10, 9, 10),
            Block.box(3, 9, 3, 13, 10, 13)
    ).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(3, 10, 3, 4, 11, 13),
            Block.box(3, 0, 3, 13, 1, 13),
            Block.box(6, 1, 6, 10, 9, 10),
            Block.box(3, 9, 3, 13, 10, 13)
    ).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    public DebugDisplayCaseBlock() {
        super(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(15f)   //strength = hardnessAndResistance
                .sound(SoundType.METAL));

        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext selectionContext) {
        switch(state.getValue(FACING)){
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    //This method checks if the block has a tileEntity.
    @Override
    public boolean hasTileEntity(BlockState state){
        return true;
    }

    //These methods are used for the block's facing.
    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING,rotation.rotate(state.getValue(FACING)));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING,context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    //This method is used to create/connect the block to its tileEntity.
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.DEBUG_DISPLAY_CASE_TILE_ENTITY_TYPE.get().create();
    }

    //This method dictates what happens when the player rightClicks the block.
    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
                                Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isClientSide()){
            TileEntity te = worldIn.getBlockEntity(pos);
            if (te instanceof DebugDisplayCaseTileEntity){
                NetworkHooks.openGui( (ServerPlayerEntity) player,(DebugDisplayCaseTileEntity) te, pos);
            }
        }
        return super.use(state, worldIn, pos, player, handIn, hit);
    }
}
